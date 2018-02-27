/*
 * Copyright (c) 2018 Memorial Sloan-Kettering Cancer Center.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY, WITHOUT EVEN THE IMPLIED WARRANTY OF MERCHANTABILITY OR FITNESS
 * FOR A PARTICULAR PURPOSE. The software and documentation provided hereunder
 * is on an "as is" basis, and Memorial Sloan-Kettering Cancer Center has no
 * obligations to provide maintenance, support, updates, enhancements or
 * modifications. In no event shall Memorial Sloan-Kettering Cancer Center be
 * liable to any party for direct, indirect, special, incidental or
 * consequential damages, including lost profits, arising out of the use of this
 * software and its documentation, even if Memorial Sloan-Kettering Cancer
 * Center has been advised of the possibility of such damage.
 */

package org.mskcc.clinical_attributes;

import java.util.*;
import org.mockito.Mockito;
import org.mskcc.clinical_attributes.model.ClinicalAttribute;
import org.mskcc.clinical_attributes.repository.ClinicalAttributesRepository;
import org.mskcc.clinical_attributes.service.internal.ClinicalAttributesCache;
import org.mskcc.clinical_attributes.repository.google.ClinicalAttributesRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClinicalAttributesTestConfig {

    @Bean
    public ClinicalAttributesCache clinicalAttributesCache() {
        Map<String, ClinicalAttribute> mockAttributeMap = makeMockAttributeMap();
        ClinicalAttributesCache cache = Mockito.mock(ClinicalAttributesCache.class);
        Mockito.when(cache.getClinicalAttributes()).thenReturn(mockAttributeMap);
        return cache;
    }

    @Bean
    public ClinicalAttributesRepository clinicalAttributesRepository() {
        return Mockito.mock(ClinicalAttributesRepository.class);
    }

    private Map<String, ClinicalAttribute> makeMockAttributeMap() {
        Map<String, ClinicalAttribute> attributeMap = new HashMap<>();
        attributeMap.put("AGE", new ClinicalAttribute("AGE", "Diagnosis Age", "Age at which a condition or disease was first diagnosed.", "NUMBER", "PATIENT", "1"));
        return Collections.unmodifiableMap(attributeMap);
    }

}
