package org.example;

import java.util.*;

public class SearchServiceImpl implements SearchService {

    @Override
    public List<User> searchForFriendsInWidth(User user, String name) {
        List<User> result = new ArrayList<>();
        if (user == null) {
            return result;
        }

        Queue<User> queue = new ArrayDeque<>();
        Set<Long> visited = new HashSet<>();

        queue.add(user);
        visited.add(user.getId());

        while (!queue.isEmpty()) {
            User current = queue.poll();
            if (name.equals(current.getName())) {
                result.add(current);
            }
            List<User> friends = current.getFriends();
            if (friends == null) continue;

            for (User friend : friends) {
                if (friend != null && visited.add(friend.getId())) {
                    queue.add(friend);
                }
            }
        }

        return result;
    }

    @Override
    public List<User> searchForFriendsInDepth(User user, String name) {
        List<User> result = new ArrayList<>();
        if (user == null) {
            return result;
        }

        Deque<User> stack = new ArrayDeque<>();
        Set<Long> visited = new HashSet<>();

        stack.push(user);
        visited.add(user.getId());

        while (!stack.isEmpty()) {
            User current = stack.pop();
            if (name.equals(current.getName())) {
                result.add(current);
            }
            List<User> friends = current.getFriends();
            if (friends == null) continue;

            ListIterator<User> it = friends.listIterator(friends.size());
            while (it.hasPrevious()) {
                User friend = it.previous();
                if (friend != null && visited.add(friend.getId())) {
                    stack.push(friend);
                }
            }
        }

        return result;
    }
}
