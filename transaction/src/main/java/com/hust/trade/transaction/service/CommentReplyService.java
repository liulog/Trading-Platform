package com.hust.trade.transaction.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hust.trade.transaction.mapper.CommentReplyMapper;
import com.hust.trade.transaction.model.CommentReply;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentReplyService {

  @Autowired
  CommentReplyMapper commentReplyMapper;

  public void delete(CommentReply commentReply){
    commentReplyMapper.deleteById(commentReply.getCommentReplyId());
  }

  public List<CommentReply> findList(CommentReply commentReply){
    QueryWrapper<CommentReply> query = new QueryWrapper<>();
    query.eq("comment_reply_id",commentReply.getCommentReplyId());
    return commentReplyMapper.selectList(query);
  }
  public void add(CommentReply commentReply){
    commentReplyMapper.insert(commentReply);
  }
}
