package com.indeed.forms.builder.resource;

import com.indeed.forms.builder.bo.QuestionBo;
import com.indeed.forms.builder.question.Question;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/question")
public class FormBuilderResource {
    @Inject
    QuestionBo questionBo;

    @GET
    @Path("{id}")
    public Question getQuestion(@PathParam("id") String id) {
        return questionBo.getQuestion(id);
    }

    @POST
    public Response addQuestion(Question question) {
        questionBo.addQuestion(question);

        return Response.accepted().build();
    }
}
