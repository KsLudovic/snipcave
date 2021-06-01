package fr.aston.snipcave.snipcave.service;

import fr.aston.snipcave.snipcave.exceptions.VoteNotFoundException;
import fr.aston.snipcave.snipcave.model.Post;
import fr.aston.snipcave.snipcave.model.Vote;
import fr.aston.snipcave.snipcave.model.User;
import fr.aston.snipcave.snipcave.repository.IVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {

    private final IVoteRepository voteRepository;

    @Autowired
    public VoteService(IVoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public Vote addVote(Vote vote) {
        return voteRepository.save(vote);
    }

    public List<Vote> findAllVote() {
        return voteRepository.findAll();
    }

    public Vote updateVote(Vote vote) {
        return voteRepository.save(vote);
    }

    public Vote finVoteByUserAndPost(User user, Post post) {
        return voteRepository.findByUserAndPost(user,post)
                .orElseThrow(() -> new VoteNotFoundException("No vote was found "));
    }

    public void deleteVote(Long id){
    voteRepository.deleteVoteById(id);
    }

}
