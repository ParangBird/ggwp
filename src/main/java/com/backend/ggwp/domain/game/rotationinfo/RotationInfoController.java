package com.backend.ggwp.domain.game.rotationinfo;

import com.backend.ggwp.aop.LogExecutionTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class RotationInfoController {
    private final RotationInfoService rotationInfoService;

    @LogExecutionTime
    @GetMapping("/api/rotationInfo")
    public RotationInfo rotationInfo() {
        return rotationInfoService.getRotationInfo("key");
    }
}
