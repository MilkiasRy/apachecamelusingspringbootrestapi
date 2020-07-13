package com.mtg.service;



import com.mtg.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtg.model.ClaimEntity;
import com.mtg.repository.ClaimRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("claimService")
public  class  ClaimServiceImp {


    @Autowired
    private ClaimRepository claimRepository;

    public void  Save(ClaimEntity claimEntity) throws ResourceNotFoundException{

            //claimRepository.save(claimEntity);




        if (claimEntity.getClaimData()==null){
            claimEntity.setClaimData(new Date());


            claimRepository.save(claimEntity);
        }
        if(claimEntity.getId()!=0){
            claimEntity.setClaimStatus("claim Regiseter");
            claimEntity.setClaimInsurranceDesc(" Claim Registration successfull..!");
            claimRepository.save(claimEntity);
        }
        else {
            claimRepository.save(claimEntity);
        }


    }

    public List<ClaimEntity> getAllListOfClaim() {

      return claimRepository.findAll();


    }
    public void delete( Long id) {

            claimRepository.deleteById(id);

    }
    public Optional<ClaimEntity> getById(long Id)
         {


        return claimRepository.findById(Id);

    }
    public ClaimEntity updateClaim( ClaimEntity claimEntity)
             {

            return this.claimRepository.save(claimEntity);



        }

    }



