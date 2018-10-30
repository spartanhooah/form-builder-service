package com.indeed.forms.builder.dao;

import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.EntityDocument;
import com.couchbase.client.java.repository.Repository;
import com.indeed.forms.builder.question.Question;

import java.util.UUID;

import static java.util.UUID.randomUUID;

public class QuestionDao {
    private Cluster cluster;

    public QuestionDao() {
        cluster = CouchbaseCluster.create();
    }

    public Question getQuestion(UUID id) {
        Repository repo = cluster.openBucket("questions").repository();
        return repo.get(id.toString(), Question.class).content();
    }

    public void add(Question question) {
        Repository repo = cluster.openBucket("questions").repository();
        EntityDocument<Question> entity = EntityDocument.create(randomUUID().toString(), question);
        repo.insert(entity);
    }
}
