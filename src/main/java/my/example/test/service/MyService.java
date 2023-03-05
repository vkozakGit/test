package my.example.test.service;

import my.example.test.dto.DataDto;
import my.example.test.entity.Post;
import my.example.test.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MyService {

	private final PostRepository postRepository;
	private final RestTemplate restTemplate;

	@Autowired
	public MyService(PostRepository postRepository, RestTemplate restTemplate) {
		this.postRepository = postRepository;
		this.restTemplate = restTemplate;
	}


	public List<Post> findAllPosts() {
		return postRepository.findAll();
	}

	public void createPost(DataDto dataDto) {
		Post post = new Post(dataDto.id(), dataDto.name());
		postRepository.save(post);
	}
}
