package tikto.utama.servlet;

import java.util.List;

import tikto.utama.ejb.Follower;

public interface IFollowerService {
    Follower addFollower(Follower newFollower);
    void deleteFollower(Integer followerId);
    List<Follower> listOfFollower();
    Follower viewDetailFollower(Integer followerId);
    Follower updatFollower(Follower updatedFollower);
}
