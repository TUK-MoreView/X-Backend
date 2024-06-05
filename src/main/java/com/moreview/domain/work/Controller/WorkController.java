package com.moreview.domain.work.Controller;

import com.moreview.domain.work.Service.WorkService;
import com.moreview.domain.work.WorkSlide;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("work-slides")
public class WorkController {

    private final WorkService workService;

    // WorkName으로 채팅방 생성
    @PostMapping
    public WorkSlide createRoom(@RequestParam("WorkName") String WorkName) {
        return workService.createWorkSlide(WorkName);
    }
}
