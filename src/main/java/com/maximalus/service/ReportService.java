package com.maximalus.service;

import com.maximalus.model.report.GeneralReport;
import com.maximalus.model.report.SalesReport;

public interface ReportService {
    void save(GeneralReport generalReport, long outletId);
    void save(SalesReport salesReport, long outletId);
}
