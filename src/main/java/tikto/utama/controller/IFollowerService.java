package tikto.utama.controller;

import java.util.List;

import tikto.utama.model.Follower;

public interface IFollowerService {
    Follower addFollower(Follower newFollower);
    void deleteFollower(Integer followerId);
    List<Follower> listOfFollower();
    Follower viewDetailFollower(Integer followerId);
    Follower updatFollower(Follower updatedFollower);
}
