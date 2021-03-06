//package com.sns.pjt.Service;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.data.redis.core.HashOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Service;
//
//import com.sns.pjt.domain.Post;
//import com.sns.pjt.domain.RedisPost;
//import com.sns.pjt.persistence.PostRepository;
//import com.sns.pjt.persistence.RedisPostRepository;
//
//@Service
//public class RedisPostServiceImpl implements RedisPostService {
//
//	@Autowired
//	private RedisTemplate redisTemplate;
//
//	@Autowired
//	private RedisPostRepository redisPostRepository;
//
//	@Autowired
//	private PostRepository postRepository;
//	
//	@Override
//	public int viewCount(int postId) {
//		// TODO Auto-generated method stub
//		HashOperations<String, String, String> hashOperation = redisTemplate.opsForHash();
//
//		int views;
//
//		hashOperation.increment("post:" + postId, "viewCnt", 1);
//
//		views = this.views(postId);
//
//		return views;
//	}
//	
//	
//	@Override
//	public int views(int postId) {
//		// TODO Auto-generated method stub
//		HashOperations<String, String, String> hashOperation = redisTemplate.opsForHash();
//
//		int views = 0;
//
//		views = this.cacheView(postId);
//	
//		return views;
//	}
//	
//	@Cacheable(value ="post", key="#postId", cacheManager="cacheManager")
//	@Transactional
//	@Override
//	public int cacheView(int postId) {
//		HashOperations<String, String, String> hashOperation = redisTemplate.opsForHash();
//
//		int views = 0;
//		
//		Post postCache = postRepository.findById(postId);
//	
//		views = Integer.valueOf((hashOperation.get("post:" +postId , "viewCnt")));
//
//		return views;
//	}
//
//	
//	@Override
//	public void insertPost(Post post) {
//		RedisPost redisPost = new RedisPost();
//
//		redisPost.setId(post.getId());
//		redisPost.setContent(post.getContent());
//		redisPost.setTitle(post.getTitle());
//		redisPost.setViewCnt(0);
//
//		redisPostRepository.save(redisPost);
//
//	}
//
//	@Override
//	public void deletePost(int postId) {
//		
//		redisPostRepository.deleteById(postId);
//		
//	}	
//
//}
