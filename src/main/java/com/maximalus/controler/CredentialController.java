package com.maximalus.controler;

import com.maximalus.dto.CredentialDto;
import com.maximalus.dto.IngredientDto;
import com.maximalus.dto.converter.CredentialDtoConverter;
import com.maximalus.dto.converter.IngredientDtoConverter;
import com.maximalus.model.Credential;
import com.maximalus.model.Role;
import com.maximalus.model.product.ingredient.Ingredient;
import com.maximalus.model.product.ingredient.IngredientGroup;
import com.maximalus.service.CredentialService;
import com.maximalus.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/credentials")
@AllArgsConstructor
public class CredentialController {
    private final CredentialService credentialService;
    private final RoleService roleService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CredentialDto getCredentialById(@PathVariable Long id){
        Credential credential = credentialService.findById(id);
        CredentialDto credentialDto = CredentialDtoConverter.toDto(credential);
        return credentialDto;
    }

    @GetMapping
    public ResponseEntity<List<CredentialDto>> getAllCredentials(){
        List<CredentialDto> credentialDtoList = credentialService.findAll().stream()
                .filter(credential -> !credential.isDeleted())
                .map(CredentialDtoConverter::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(credentialDtoList);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Credential createCredential(@RequestBody CredentialDto credentialDto){
        Credential credential = CredentialDtoConverter.fromDto(credentialDto);
        return credentialService.save(credential);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Credential updateCredential(@PathVariable Long id,
                                       @RequestBody CredentialDto credentialDto){
        Credential credential = CredentialDtoConverter.fromDto(credentialDto);
        Role role = roleService.findByName(credentialDto.getRoleName());
        credential.setId(id);
        credential.setRole(role);
        return credentialService.update(credential);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCredentialById(@PathVariable Long id){
        credentialService.deleteById(id);
    }

    @GetMapping("/search")
    public List<CredentialDto> getByPageAndSize(@QueryParam("page")Integer page,
                                             @QueryParam("size")Integer size){
        return credentialService.findAll(PageRequest.of(page, size)).getContent()
                .stream().map(CredentialDtoConverter::toDto)
                .collect(Collectors.toList());
    }
}
