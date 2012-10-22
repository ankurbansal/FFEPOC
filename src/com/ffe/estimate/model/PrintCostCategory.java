package com.ffe.estimate.model;

 

import java.math.BigDecimal;

import com.ffe.common.framework.model.AbstractDomain;

 

/**

 * Estimate generated by hbm2java

 */

public class PrintCostCategory extends AbstractDomain implements java.io.Serializable {

            private static final long serialVersionUID = -4744105404866811257L;
            private Long estimateCostTypeId;            
            private Long serviceTemplateId;
            private Long vendorId;
            private BigDecimal totalCost;      
            private String comments;
            private Long printCostCategoryID;
            private FilmEstimate filmEstimate;
          

            public BigDecimal getTotalCost() {
				return totalCost;
			}



			public void setTotalCost(BigDecimal totalCost) {
				this.totalCost = totalCost;
			}



			



			public Long getPrintCostCategoryID() {
				return printCostCategoryID;
			}



			public void setPrintCostCategoryID(Long printCostCategoryID) {
				this.printCostCategoryID = printCostCategoryID;
			}



			public FilmEstimate getFilmEstimate() {
				return filmEstimate;
			}



			public void setFilmEstimate(FilmEstimate filmEstimate) {
				this.filmEstimate = filmEstimate;
			}



			public PrintCostCategory(Long estimateCostTypeId, Long serviceTemplateId,

                                    Long vendorId, BigDecimal totalCost, String comments) {

                        super();

                        this.estimateCostTypeId = estimateCostTypeId;

                        this.serviceTemplateId = serviceTemplateId;

                        this.vendorId = vendorId;

                        this.totalCost = totalCost;

                        this.comments = comments;

            }

            

            public PrintCostCategory() {

            

            }

 

            public Long getEstimateCostTypeId() {

                        return estimateCostTypeId;

            }

            public void setEstimateCostTypeId(Long estimateCostTypeId) {

                        this.estimateCostTypeId = estimateCostTypeId;

            }

            public Long getServiceTemplateId() {

                        return serviceTemplateId;

            }

            public void setServiceTemplateId(Long serviceTemplateId) {

                        this.serviceTemplateId = serviceTemplateId;

            }

            public Long getVendorId() {

                        return vendorId;

            }

            public void setVendorId(Long vendorId) {

                        this.vendorId = vendorId;

            }

            public BigDecimal gettotalCost() {

                        return totalCost;

            }

            public void settotalCost(BigDecimal totalCost) {

                        this.totalCost = totalCost;

            }

            public String getComments() {

                        return comments;

            }

            public void setComments(String comments) {

                        this.comments = comments;

            }

 

}