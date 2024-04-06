package com.example.backend.controller.Authentication;


import com.example.backend.domain.ResponseResult;
import com.example.backend.domain.user.User;
import com.example.backend.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("user")
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    /**
     * Sign up
     *
     * @param user
     * @return
     */
    @PostMapping("register")
    public ResponseResult register(@RequestBody User user) {
        return registerService.register(user);
    }

}
