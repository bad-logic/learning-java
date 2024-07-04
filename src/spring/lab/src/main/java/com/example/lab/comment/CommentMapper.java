package com.example.lab.comment;

import com.example.lab.comment.dto.CommentDTO;
import com.example.lab.comment.dto.CreateCommentDTO;

public class CommentMapper {

    public static Comment toEntity(CreateCommentDTO data) {
        if (data == null) return null;
        Comment comment = new Comment();
        comment.setComment(data.getComment());
        return comment;
    }

    public static CommentDTO toCommentDTO(Comment c) {
        if (c == null) return null;
        return new CommentDTO(c.getId(), c.getComment(), c.getPostId());
    }
}
