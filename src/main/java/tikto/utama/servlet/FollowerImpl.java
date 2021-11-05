package tikto.utama.servlet;

import java.util.ArrayList;
import java.util.List;

import tikto.utama.ejb.Follower;

public class FollowerImpl implements IFollowerService {

	private List<Follower> followerList = new ArrayList<Follower>();

	@Override
	public Follower addFollower(Follower newFollower) {
		followerList.add(newFollower);
		return newFollower;
	}

	@Override
	public void deleteFollower(Integer followerId) {
		followerList.remove(followerId);
	}

	@Override
	public List<Follower> listOfFollower() {

		return followerList;
	}

	@Override
	public Follower viewDetailFollower(Integer followerId) {
		Follower findData = followerList.get(followerId);
		return findData;
	}

	@Override
	public Follower updatFollower(Follower updatedFollower) {
		Integer idKey = updatedFollower.getId();
		followerList.set(idKey, updatedFollower);
		return null;
	}

}
