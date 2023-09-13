package com.mohim.api.controller;

import com.mohim.api.dto.*;
import com.mohim.api.service.MemberService;
import com.mohim.api.service.ProfileImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/churches")
public class MemberController {

    private final MemberService memberService;
    private final ProfileImageService profileImageService;

    // 교회 멤버 가져오기
    @GetMapping("/{church_id}/members")
    public ResponseEntity<ChurchMembersResponse> getChurchMembers(@PathVariable("church_id") Integer churchId, @ModelAttribute ChurchMembersRequest request, HttpServletRequest httpServletRequest) {
        ChurchMembersResponse response = memberService.getChurchMembers(churchId, request, httpServletRequest);
        return ResponseEntity.ok().body(response);
    }

    // 특정 멤버 정보 가져오기
    @GetMapping("/{church_id}/members/{member_id}")
    public ResponseEntity<ChurchMemberResponse> getChurchMember(@PathVariable("church_id") Integer churchId, @PathVariable("member_id") Integer memberId) {
        ChurchMemberResponse response = memberService.getChurchMember(churchId, memberId);
        return ResponseEntity.ok().body(response);
    }

    // 프로필 이미지 가져오기
    @GetMapping("/{church_id}/members/{member_id}/profile-image-url")
    public ResponseEntity<ProfileImageUrlResponse> getMinistryRole(@PathVariable("church_id") Integer churchId, @PathVariable("member_id") Integer memberId) {
        ProfileImageUrlResponse response = profileImageService.getProfileImageUrl(churchId, memberId);
        return ResponseEntity.ok().body(response);
    }
}
