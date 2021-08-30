/*
 * Copyright (c) 1998, 2021 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     Oracle - initial API and implementation from Oracle TopLink
package org.eclipse.persistence.testing.models.insurance;

import org.eclipse.persistence.mappings.*;
import org.eclipse.persistence.mappings.converters.*;
import org.eclipse.persistence.descriptors.RelationalDescriptor;
import org.eclipse.persistence.sessions.*;

/**
 * This class was generated by the TopLink project class generator.
 * It stores the meta-data (descriptors) that define the TopLink mappings.
 * @see org.eclipse.persistence.tools.workbench.ProjectClassGenerator
 */
public class InsuranceProject extends org.eclipse.persistence.sessions.Project {
    public InsuranceProject() {
        setName("Insurance");
        applyLogin();

        addDescriptor(buildAddressDescriptor());
        addDescriptor(buildClaimDescriptor());
        addDescriptor(buildHealthClaimDescriptor());
        addDescriptor(buildHealthPolicyDescriptor());
        addDescriptor(buildHouseClaimDescriptor());
        addDescriptor(buildHousePolicyDescriptor());
        addDescriptor(buildPhoneDescriptor());
        addDescriptor(buildPolicyDescriptor());
        addDescriptor(buildPolicyHolderDescriptor());
        addDescriptor(buildVehicleClaimDescriptor());
        addDescriptor(buildVehiclePolicyDescriptor());
        addDescriptor(buildBicyclePolicyDescriptor());
    }

    public void applyLogin() {
        DatabaseLogin login = new DatabaseLogin();
        setLogin(login);
    }

    public RelationalDescriptor buildAddressDescriptor() {
        RelationalDescriptor descriptor = new RelationalDescriptor();
        descriptor.setJavaClass(org.eclipse.persistence.testing.models.insurance.Address.class);
        descriptor.addTableName("INS_ADDR");
        descriptor.addPrimaryKeyFieldName("INS_ADDR.SSN");

        // Mappings.
        DirectToFieldMapping cityMapping = new DirectToFieldMapping();
        cityMapping.setAttributeName("city");
        cityMapping.setGetMethodName("getCity");
        cityMapping.setSetMethodName("setCity");
        cityMapping.setFieldName("INS_ADDR.CITY");
        descriptor.addMapping(cityMapping);

        DirectToFieldMapping countryMapping = new DirectToFieldMapping();
        countryMapping.setAttributeName("country");
        countryMapping.setGetMethodName("getCountry");
        countryMapping.setSetMethodName("setCountry");
        countryMapping.setFieldName("INS_ADDR.COUNTRY");
        descriptor.addMapping(countryMapping);

        DirectToFieldMapping stateMapping = new DirectToFieldMapping();
        stateMapping.setAttributeName("state");
        stateMapping.setGetMethodName("getState");
        stateMapping.setSetMethodName("setState");
        stateMapping.setFieldName("INS_ADDR.STATE");
        descriptor.addMapping(stateMapping);

        DirectToFieldMapping streetMapping = new DirectToFieldMapping();
        streetMapping.setAttributeName("street");
        streetMapping.setGetMethodName("getStreet");
        streetMapping.setSetMethodName("setStreet");
        streetMapping.setFieldName("INS_ADDR.STREET");
        descriptor.addMapping(streetMapping);

        DirectToFieldMapping zipCodeMapping = new DirectToFieldMapping();
        zipCodeMapping.setAttributeName("zipCode");
        zipCodeMapping.setGetMethodName("getZipCode");
        zipCodeMapping.setSetMethodName("setZipCode");
        zipCodeMapping.setFieldName("INS_ADDR.ZIPCODE");
        descriptor.addMapping(zipCodeMapping);

        OneToOneMapping policyHolderMapping = new OneToOneMapping();
        policyHolderMapping.setAttributeName("policyHolder");
        policyHolderMapping.setGetMethodName("getPolicyHolder");
        policyHolderMapping.setSetMethodName("setPolicyHolder");
        policyHolderMapping.setReferenceClass(org.eclipse.persistence.testing.models.insurance.PolicyHolder.class);
        policyHolderMapping.dontUseIndirection();
        policyHolderMapping.addForeignKeyFieldName("INS_ADDR.SSN", "HOLDER.SSN");
        descriptor.addMapping(policyHolderMapping);

        return descriptor;
    }

    public RelationalDescriptor buildClaimDescriptor() {
        RelationalDescriptor descriptor = new RelationalDescriptor();
        descriptor.setJavaClass(org.eclipse.persistence.testing.models.insurance.Claim.class);
        descriptor.addTableName("CLAIM");
        descriptor.addPrimaryKeyFieldName("CLAIM.CLM_ID");

        // Inheritance properties.
        descriptor.getDescriptorInheritancePolicy().setClassIndicatorFieldName("CLAIM.CLM_TYPE");
        descriptor.getDescriptorInheritancePolicy().addClassIndicator(org.eclipse.persistence.testing.models.insurance.HealthClaim.class, "E");
        descriptor.getDescriptorInheritancePolicy().addClassIndicator(org.eclipse.persistence.testing.models.insurance.VehicleClaim.class, "V");
        descriptor.getDescriptorInheritancePolicy().addClassIndicator(org.eclipse.persistence.testing.models.insurance.HouseClaim.class, "H");

        // Mappings.
        DirectToFieldMapping amountMapping = new DirectToFieldMapping();
        amountMapping.setAttributeName("amount");
        amountMapping.setGetMethodName("getAmount");
        amountMapping.setSetMethodName("setAmount");
        amountMapping.setFieldName("CLAIM.AMOUNT");
        descriptor.addMapping(amountMapping);

        DirectToFieldMapping idMapping = new DirectToFieldMapping();
        idMapping.setAttributeName("id");
        idMapping.setGetMethodName("getId");
        idMapping.setSetMethodName("setId");
        idMapping.setFieldName("CLAIM.CLM_ID");
        descriptor.addMapping(idMapping);

        OneToOneMapping policyMapping = new OneToOneMapping();
        policyMapping.setAttributeName("policy");
        policyMapping.setGetMethodName("getPolicy");
        policyMapping.setSetMethodName("setPolicy");
        policyMapping.setReferenceClass(org.eclipse.persistence.testing.models.insurance.Policy.class);
        policyMapping.dontUseIndirection();
        policyMapping.addForeignKeyFieldName("CLAIM.POL_ID", "POLICY.POL_ID");
        descriptor.addMapping(policyMapping);

        return descriptor;
    }

    public RelationalDescriptor buildHealthClaimDescriptor() {
        RelationalDescriptor descriptor = new RelationalDescriptor();
        descriptor.setJavaClass(org.eclipse.persistence.testing.models.insurance.HealthClaim.class);
        descriptor.addTableName("CLAIM");

        // Inheritance properties.
        descriptor.getDescriptorInheritancePolicy().setParentClass(org.eclipse.persistence.testing.models.insurance.Claim.class);

        // RelationalDescriptor properties.
        // Query manager.
        descriptor.getDescriptorQueryManager().checkDatabaseForDoesExist();

        // Event manager.
        // Mappings.
        DirectToFieldMapping diseaseMapping = new DirectToFieldMapping();
        diseaseMapping.setAttributeName("disease");
        diseaseMapping.setGetMethodName("getDisease");
        diseaseMapping.setSetMethodName("setDisease");
        diseaseMapping.setFieldName("CLAIM.DISEASE");
        descriptor.addMapping(diseaseMapping);

        return descriptor;
    }

    public RelationalDescriptor buildHealthPolicyDescriptor() {
        RelationalDescriptor descriptor = new RelationalDescriptor();
        descriptor.setJavaClass(org.eclipse.persistence.testing.models.insurance.HealthPolicy.class);
        descriptor.addTableName("POLICY");

        // Inheritance properties.
        descriptor.getDescriptorInheritancePolicy().setParentClass(org.eclipse.persistence.testing.models.insurance.Policy.class);

        // RelationalDescriptor properties.
        // Query manager.
        descriptor.getDescriptorQueryManager().checkDatabaseForDoesExist();

        // Event manager.
        // Mappings.
        DirectToFieldMapping coverageRateMapping = new DirectToFieldMapping();
        coverageRateMapping.setAttributeName("coverageRate");
        coverageRateMapping.setGetMethodName("getCoverageRate");
        coverageRateMapping.setSetMethodName("setCoverageRate");
        coverageRateMapping.setFieldName("POLICY.COV_RATE");
        descriptor.addMapping(coverageRateMapping);

        return descriptor;
    }

    public RelationalDescriptor buildHouseClaimDescriptor() {
        RelationalDescriptor descriptor = new RelationalDescriptor();
        descriptor.setJavaClass(org.eclipse.persistence.testing.models.insurance.HouseClaim.class);
        descriptor.addTableName("CLAIM");

        // Inheritance properties.
        descriptor.getDescriptorInheritancePolicy().setParentClass(org.eclipse.persistence.testing.models.insurance.Claim.class);

        // RelationalDescriptor properties.
        // Query manager.
        descriptor.getDescriptorQueryManager().checkDatabaseForDoesExist();

        // Event manager.
        // Mappings.
        DirectToFieldMapping areaMapping = new DirectToFieldMapping();
        areaMapping.setAttributeName("area");
        areaMapping.setGetMethodName("getArea");
        areaMapping.setSetMethodName("setArea");
        areaMapping.setFieldName("CLAIM.AREA");
        descriptor.addMapping(areaMapping);

        return descriptor;
    }

    public RelationalDescriptor buildHousePolicyDescriptor() {
        RelationalDescriptor descriptor = new RelationalDescriptor();
        descriptor.setJavaClass(org.eclipse.persistence.testing.models.insurance.HousePolicy.class);
        descriptor.addTableName("POLICY");

        // Inheritance properties.
        descriptor.getDescriptorInheritancePolicy().setParentClass(org.eclipse.persistence.testing.models.insurance.Policy.class);

        // RelationalDescriptor properties.
        // Query manager.
        descriptor.getDescriptorQueryManager().checkDatabaseForDoesExist();

        // Event manager.
        // Mappings.
        DirectToFieldMapping dateOfConstructionMapping = new DirectToFieldMapping();
        dateOfConstructionMapping.setAttributeName("dateOfConstruction");
        dateOfConstructionMapping.setGetMethodName("getDateOfConstruction");
        dateOfConstructionMapping.setSetMethodName("setDateOfConstruction");
        dateOfConstructionMapping.setFieldName("POLICY.CNST_DTE");
        descriptor.addMapping(dateOfConstructionMapping);

        return descriptor;
    }

    public RelationalDescriptor buildPhoneDescriptor() {
        RelationalDescriptor descriptor = new RelationalDescriptor();
        descriptor.setJavaClass(org.eclipse.persistence.testing.models.insurance.Phone.class);
        descriptor.addTableName("INS_PHONE");
        descriptor.addPrimaryKeyFieldName("INS_PHONE.HOLDER_SSN");
        descriptor.addPrimaryKeyFieldName("INS_PHONE.TYPE");

        descriptor.setAmendmentClass(org.eclipse.persistence.testing.models.insurance.InsuranceSystem.class);
        descriptor.setAmendmentMethodName("modifyPhoneDescriptor");

        // Mappings.
        DirectToFieldMapping areaCodeMapping = new DirectToFieldMapping();
        areaCodeMapping.setAttributeName("areaCode");
        areaCodeMapping.setGetMethodName("getAreaCode");
        areaCodeMapping.setSetMethodName("setAreaCode");
        areaCodeMapping.setFieldName("INS_PHONE.AREACODE");
        descriptor.addMapping(areaCodeMapping);

        DirectToFieldMapping numberMapping = new DirectToFieldMapping();
        numberMapping.setAttributeName("number");
        numberMapping.setGetMethodName("getNumber");
        numberMapping.setSetMethodName("setNumber");
        numberMapping.setFieldName("INS_PHONE.PHONE_NUMBER");
        descriptor.addMapping(numberMapping);

        DirectToFieldMapping typeMapping = new DirectToFieldMapping();
        typeMapping.setAttributeName("type");
        typeMapping.setGetMethodName("getType");
        typeMapping.setSetMethodName("setType");
        typeMapping.setFieldName("INS_PHONE.TYPE");
        descriptor.addMapping(typeMapping);

        descriptor.applyAmendmentMethod();
        return descriptor;
    }

    public RelationalDescriptor buildPolicyDescriptor() {
        RelationalDescriptor descriptor = new RelationalDescriptor();
        descriptor.setJavaClass(org.eclipse.persistence.testing.models.insurance.Policy.class);
        descriptor.addTableName("POLICY");
        descriptor.addPrimaryKeyFieldName("POLICY.POL_ID");

        // Inheritance properties.
        descriptor.getDescriptorInheritancePolicy().setClassIndicatorFieldName("POLICY.POL_TYPE");
        descriptor.getDescriptorInheritancePolicy().addClassIndicator(org.eclipse.persistence.testing.models.insurance.HousePolicy.class, Long.valueOf(3));
        descriptor.getDescriptorInheritancePolicy().addClassIndicator(org.eclipse.persistence.testing.models.insurance.HealthPolicy.class, Long.valueOf(2));
        descriptor.getDescriptorInheritancePolicy().addClassIndicator(org.eclipse.persistence.testing.models.insurance.VehiclePolicy.class, Long.valueOf(1));
        descriptor.getDescriptorInheritancePolicy().addClassIndicator(org.eclipse.persistence.testing.models.insurance.BicyclePolicy.class, Long.valueOf(0));

        // Mappings.
        DirectToFieldMapping policyNumberMapping = new DirectToFieldMapping();
        policyNumberMapping.setAttributeName("policyNumber");
        policyNumberMapping.setGetMethodName("getPolicyNumber");
        policyNumberMapping.setSetMethodName("setPolicyNumber");
        policyNumberMapping.setFieldName("POLICY.POL_ID");
        descriptor.addMapping(policyNumberMapping);

        DirectToFieldMapping maxCoverageMapping = new DirectToFieldMapping();
        maxCoverageMapping.setAttributeName("maxCoverage");
        maxCoverageMapping.setGetMethodName("getMaxCoverage");
        maxCoverageMapping.setSetMethodName("setMaxCoverage");
        maxCoverageMapping.setFieldName("POLICY.MAX_COV");
        descriptor.addMapping(maxCoverageMapping);

        DirectToFieldMapping descriptionMapping = new DirectToFieldMapping();
        descriptionMapping.setAttributeName("description");
        descriptionMapping.setGetMethodName("getDescription");
        descriptionMapping.setSetMethodName("setDescription");
        descriptionMapping.setFieldName("POLICY.DESCRIPT");
        descriptor.addMapping(descriptionMapping);

        OneToOneMapping policyHolderMapping = new OneToOneMapping();
        policyHolderMapping.setAttributeName("policyHolder");
        policyHolderMapping.setGetMethodName("getPolicyHolder");
        policyHolderMapping.setSetMethodName("setPolicyHolder");
        policyHolderMapping.setReferenceClass(org.eclipse.persistence.testing.models.insurance.PolicyHolder.class);
        policyHolderMapping.dontUseIndirection();
        policyHolderMapping.addForeignKeyFieldName("POLICY.SSN", "HOLDER.SSN");
        descriptor.addMapping(policyHolderMapping);

        OneToManyMapping claimsMapping = new OneToManyMapping();
        claimsMapping.setAttributeName("claims");
        claimsMapping.setGetMethodName("getClaims");
        claimsMapping.setSetMethodName("setClaims");
        claimsMapping.setReferenceClass(org.eclipse.persistence.testing.models.insurance.Claim.class);
        claimsMapping.dontUseIndirection();
        claimsMapping.privateOwnedRelationship();
        claimsMapping.addTargetForeignKeyFieldName("CLAIM.POL_ID", "POLICY.POL_ID");
        descriptor.addMapping(claimsMapping);

        return descriptor;
    }

    public RelationalDescriptor buildPolicyHolderDescriptor() {
        RelationalDescriptor descriptor = new RelationalDescriptor();
        descriptor.setJavaClass(org.eclipse.persistence.testing.models.insurance.PolicyHolder.class);
        descriptor.addTableName("HOLDER");
        descriptor.addPrimaryKeyFieldName("HOLDER.SSN");
        descriptor.setAmendmentClass(org.eclipse.persistence.testing.models.insurance.InsuranceSystem.class);
        descriptor.setAmendmentMethodName("modifyPolicyHolderDescriptor");

        // Mappings.
        DirectToFieldMapping birthDateMapping = new DirectToFieldMapping();
        birthDateMapping.setAttributeName("birthDate");
        birthDateMapping.setGetMethodName("getBirthDate");
        birthDateMapping.setSetMethodName("setBirthDate");
        birthDateMapping.setFieldName("HOLDER.BDATE");
        descriptor.addMapping(birthDateMapping);

        DirectToFieldMapping firstNameMapping = new DirectToFieldMapping();
        firstNameMapping.setAttributeName("firstName");
        firstNameMapping.setGetMethodName("getFirstName");
        firstNameMapping.setSetMethodName("setFirstName");
        firstNameMapping.setFieldName("HOLDER.F_NAME");
        descriptor.addMapping(firstNameMapping);

        DirectToFieldMapping lastNameMapping = new DirectToFieldMapping();
        lastNameMapping.setAttributeName("lastName");
        lastNameMapping.setGetMethodName("getLastName");
        lastNameMapping.setSetMethodName("setLastName");
        lastNameMapping.setFieldName("HOLDER.L_NAME");
        descriptor.addMapping(lastNameMapping);

        DirectToFieldMapping occupationMapping = new DirectToFieldMapping();
        occupationMapping.setAttributeName("occupation");
        occupationMapping.setGetMethodName("getOccupation");
        occupationMapping.setSetMethodName("setOccupation");
        occupationMapping.setFieldName("HOLDER.OCC");
        descriptor.addMapping(occupationMapping);

        DirectToFieldMapping ssnMapping = new DirectToFieldMapping();
        ssnMapping.setAttributeName("ssn");
        ssnMapping.setGetMethodName("getSsn");
        ssnMapping.setSetMethodName("setSsn");
        ssnMapping.setFieldName("HOLDER.SSN");
        descriptor.addMapping(ssnMapping);

        DirectToFieldMapping sexMapping = new DirectToFieldMapping();
        sexMapping.setAttributeName("sex");
        sexMapping.setGetMethodName("getSex");
        sexMapping.setSetMethodName("setSex");
        sexMapping.setFieldName("HOLDER.SEX");
        ObjectTypeConverter sexConverter = new ObjectTypeConverter();
        sexConverter.addConversionValue(Character.valueOf('F'), "Female");
        sexConverter.addConversionValue(Character.valueOf('M'), "Male");
        sexMapping.setConverter(sexConverter);
        descriptor.addMapping(sexMapping);

        DirectCollectionMapping childrenNamesMapping = new DirectCollectionMapping();
        childrenNamesMapping.setAttributeName("childrenNames");
        childrenNamesMapping.setGetMethodName("getChildrenNames");
        childrenNamesMapping.setSetMethodName("setChildrenNames");
        childrenNamesMapping.dontUseIndirection();
        childrenNamesMapping.setReferenceTableName("CHILDNAM");
        childrenNamesMapping.setDirectFieldName("CHILDNAM.CHILD_NAME");
        childrenNamesMapping.addReferenceKeyFieldName("CHILDNAM.HOLDER_ID", "HOLDER.SSN");
        descriptor.addMapping(childrenNamesMapping);

        OneToOneMapping addressMapping = new OneToOneMapping();
        addressMapping.setAttributeName("address");
        addressMapping.setGetMethodName("getAddress");
        addressMapping.setSetMethodName("internalSetAddress");
        addressMapping.setReferenceClass(org.eclipse.persistence.testing.models.insurance.Address.class);
        addressMapping.dontUseIndirection();
        addressMapping.privateOwnedRelationship();
        addressMapping.addTargetForeignKeyFieldName("INS_ADDR.SSN", "HOLDER.SSN");
        descriptor.addMapping(addressMapping);

        OneToManyMapping policiesMapping = new OneToManyMapping();
        policiesMapping.setAttributeName("policies");
        policiesMapping.setGetMethodName("getPolicies");
        policiesMapping.setSetMethodName("setPolicies");
        policiesMapping.setReferenceClass(org.eclipse.persistence.testing.models.insurance.Policy.class);
        policiesMapping.dontUseIndirection();
        policiesMapping.privateOwnedRelationship();
        policiesMapping.addTargetForeignKeyFieldName("POLICY.SSN", "HOLDER.SSN");
        descriptor.addMapping(policiesMapping);

        descriptor.applyAmendmentMethod();
        return descriptor;
    }

    public RelationalDescriptor buildVehicleClaimDescriptor() {
        RelationalDescriptor descriptor = new RelationalDescriptor();
        descriptor.setJavaClass(org.eclipse.persistence.testing.models.insurance.VehicleClaim.class);
        descriptor.addTableName("VHCL_CLM");

        // Inheritance properties.
        descriptor.getDescriptorInheritancePolicy().setParentClass(org.eclipse.persistence.testing.models.insurance.Claim.class);

        // RelationalDescriptor properties.
        // Query manager.
        descriptor.getDescriptorQueryManager().checkDatabaseForDoesExist();

        // Event manager.
        // Mappings.
        DirectToFieldMapping partMapping = new DirectToFieldMapping();
        partMapping.setAttributeName("part");
        partMapping.setGetMethodName("getPart");
        partMapping.setSetMethodName("setPart");
        partMapping.setFieldName("VHCL_CLM.PART");
        descriptor.addMapping(partMapping);

        DirectToFieldMapping partDescriptionMapping = new DirectToFieldMapping();
        partDescriptionMapping.setAttributeName("partDescription");
        partDescriptionMapping.setGetMethodName("getPartDescription");
        partDescriptionMapping.setSetMethodName("setPartDescription");
        partDescriptionMapping.setFieldName("VHCL_CLM.PART_DESC");
        descriptor.addMapping(partDescriptionMapping);

        return descriptor;
    }

    public RelationalDescriptor buildVehiclePolicyDescriptor() {
        RelationalDescriptor descriptor = new RelationalDescriptor();
        descriptor.setJavaClass(org.eclipse.persistence.testing.models.insurance.VehiclePolicy.class);
        descriptor.addTableName("VHCL_POL");

        // Inheritance properties.
        descriptor.getDescriptorInheritancePolicy().setParentClass(org.eclipse.persistence.testing.models.insurance.Policy.class);

        // RelationalDescriptor properties.
        // Query manager.
        descriptor.getDescriptorQueryManager().checkDatabaseForDoesExist();

        // Event manager.
        // Mappings.
        DirectToFieldMapping modelMapping = new DirectToFieldMapping();
        modelMapping.setAttributeName("model");
        modelMapping.setGetMethodName("getModel");
        modelMapping.setSetMethodName("setModel");
        modelMapping.setFieldName("VHCL_POL.MODEL");
        descriptor.addMapping(modelMapping);

        return descriptor;
    }

    public RelationalDescriptor buildBicyclePolicyDescriptor() {
        RelationalDescriptor descriptor = new RelationalDescriptor();
        descriptor.setJavaClass(org.eclipse.persistence.testing.models.insurance.BicyclePolicy.class);
        descriptor.addTableName("BCCL_POL");

        // Inheritance properties.
        descriptor.getDescriptorInheritancePolicy().setParentClass(org.eclipse.persistence.testing.models.insurance.VehiclePolicy.class);

        // RelationalDescriptor properties.
        // Query manager.
        descriptor.getDescriptorQueryManager().checkDatabaseForDoesExist();

        // Event manager.
        // Mappings.
        DirectToFieldMapping colorMapping = new DirectToFieldMapping();
        colorMapping.setAttributeName("model");
        colorMapping.setGetMethodName("getColor");
        colorMapping.setSetMethodName("setColor");
        colorMapping.setFieldName("BCCL_POL.COLOR");
        descriptor.addMapping(colorMapping);

        return descriptor;
    }
}
