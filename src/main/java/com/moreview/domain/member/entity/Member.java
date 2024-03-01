package com.moreview.domain.member.entity;

import com.moreview.domain.base.BaseEntity;
import com.moreview.domain.member.editor.MemberEditor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.*;

@Getter
@Builder
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String memberName;

    private String name;

    @Email
    private String email;

    private String role;

    public MemberEditor.MemberEditorBuilder toEditor() {
        return MemberEditor.builder()
                .name(name)
                .email(email);
    }

}
