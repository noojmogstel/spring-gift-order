package gift.service;

import gift.entity.SnsMember;
import gift.repository.SnsMemberRepository;
import org.springframework.stereotype.Service;

@Service
public class SnsMemberService {

    private final SnsMemberRepository snsMemberRepository;

    public SnsMemberService(SnsMemberRepository snsMemberRepository) {
        this.snsMemberRepository = snsMemberRepository;
    }

    public String getOauthAccessTokenByEmail(String email) {
        SnsMember snsMember = snsMemberRepository.findByEmail(email)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        return snsMember.getOauthAccessToken();
    }
}
