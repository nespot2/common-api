package com.nespot2.commonapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nespot2.commonapi.member.domain.dto.LoginDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * spring rest doc test code
 */
@SpringBootTest
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
class CommonControllerTests {

    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext,
                      RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .apply(documentationConfiguration(restDocumentation))
                .build();
    }

    /**
     * login
     * @throws Exception
     */
    @Test
    void login() throws Exception {

        final String codeDescription = "SUCCESS : 성공\nUNAUTHENTICATED : 인증 실패\nERROR : 서버 에러";

        final RestDocumentationResultHandler document = document("login",
                requestFields(
                        fieldWithPath("email").type(JsonFieldType.STRING).description("이메일"),
                        fieldWithPath("password").type(JsonFieldType.STRING).description("패스워드")
                ),
                responseFields(
                        fieldWithPath("c").type(JsonFieldType.STRING).description(codeDescription),
                        fieldWithPath("m").type(JsonFieldType.STRING).description("결과 메시지"),
                        fieldWithPath("t").type(JsonFieldType.STRING).description("호출 시간"),
                        fieldWithPath("d.token").type(JsonFieldType.STRING).description("token").optional(),
                        fieldWithPath("d.refreshToken").type(JsonFieldType.STRING).description("refresh token").optional())
        );

        final LoginDto loginDto = LoginDto.builder()
                .email("nespot2@gmail.com")
                .password("hello1234!")
                .build();
        this.mockMvc
                .perform(
                        post("/login")
                                .content(objectMapper.writeValueAsString(loginDto))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andDo(document);
    }

}
