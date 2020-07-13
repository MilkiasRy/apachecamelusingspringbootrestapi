package com.mtg.model;

import java.util.Date;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Claim Api")
public class ClaimEntity {


    @ApiModelProperty(value = "Id of Claim", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ApiModelProperty(value = "claim Data", required = true)
    private Date claimData;
    @ApiModelProperty(value = "claim Status", required = true)
    private String claimStatus;
    @ApiModelProperty(value = "claim Insurrance Desc", required = true)
    private String claimInsurranceDesc;
    @ApiModelProperty(value = "ClaimInsurance", required = true)
    private String claimInsurranceId;


}