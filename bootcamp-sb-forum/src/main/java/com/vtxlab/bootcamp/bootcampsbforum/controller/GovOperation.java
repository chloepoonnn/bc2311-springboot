package com.vtxlab.bootcamp.bootcampsbforum.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bootcamp.bootcampsbforum.annotation.UserIdCheck;
import com.vtxlab.bootcamp.bootcampsbforum.dto.UserDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.UserIdRQTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserCommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResp;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ResourceNotFound;

@Validated
public interface GovOperation {
        @GetMapping(value = "/user")
        @ResponseStatus(value = HttpStatus.OK)
        ApiResp<UserPostDTO> getUser(@UserIdCheck @RequestParam(
                        value = "id") UserIdRQTO userId);

        @GetMapping(value = "/users")
        @ResponseStatus(value = HttpStatus.OK)
        ApiResp<List<UserPostDTO>> getUsers();

        @GetMapping(value = "/userComments")
        @ResponseStatus(value = HttpStatus.OK)
        ApiResp<List<UserCommentDTO>> getUserComments(
                        @RequestParam(value = "email") int email);

        // @GetMapping(value = "/user2")
        // ApiResp<UserPostDTO> getUser2(String userId) throws ResourceNotFound;

        @GetMapping(value = "/test/npe")
        String testNPE();

        @GetMapping(value = "/test/modelmapper")
        UserDTO testModelMapper();
}
