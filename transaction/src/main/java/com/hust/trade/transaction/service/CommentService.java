package com.hust.trade.transaction.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hust.trade.transaction.mapper.CommentMapper;
import com.hust.trade.transaction.model.Comment;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
  @Autowired
  CommentMapper commentMapper;

  public void delete(Comment comment){
    commentMapper.deleteById(comment.getCommentId());
  }
  public List<Comment> findList(Comment comment){
    QueryWrapper<Comment> query = new QueryWrapper<>();
    query.eq("message_id",comment.getMessageId());
    return commentMapper.selectList(query);
  }

  public void add(Comment comment){
    commentMapper.insert(comment);
  }
}
