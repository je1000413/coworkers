package com.pausehyeon.coworkers.unittest;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.pausehyeon.coworkers.controllers.MeetingRoomController;
import com.pausehyeon.coworkers.services.MeetingRoomService;
import com.pausehyeon.coworkers.services.ResponseCodeService;

@RunWith(SpringRunner.class)
@WebMvcTest(MeetingRoomController.class)
@AutoConfigureRestDocs
public class MeetingRoomControllerTest {

    @Autowired
    private MockMvc mvc;
    
    @MockBean
    private MeetingRoomService service;
    
    @MockBean
    private ResponseCodeService responseService;
    
    @Test
    public void whenGetMeetingRooms_thenReturnJsonArray() throws Exception{
    	
    	mvc.perform(get("/meeting-rooms").contentType(MediaType.APPLICATION_JSON))
    	.andExpect(status().isOk())
    	.andDo(document("meeting-rooms"));
//    	.andDo(document("meeting-rooms", pathParameters(parameterWithName("test").description("테스트 파라미터"))));
    }
}