package org.gso.profiles.repository;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gso.profiles.model.ProfileModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

@Slf4j
@RequiredArgsConstructor
@Repository
public class CustomProfileRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public Page<ProfileModel> searchProfiles(Criteria criteria, Pageable pageable) {
        Query query = new Query().addCriteria(criteria).with(pageable);
        List<ProfileModel> results = mongoTemplate.find(query, ProfileModel.class);
        Page<ProfileModel> profilesPage = PageableExecutionUtils.getPage(
                results,
                pageable,
                () -> mongoTemplate.count(query, ProfileModel.class));
        return profilesPage;
    }
}
