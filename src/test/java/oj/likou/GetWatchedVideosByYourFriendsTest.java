/*
 * Copyright (c) 2010-2020.
 *  Date:20-5-24 下午10:43
 * Author:cooper
 */

package oj.likou;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;

public class GetWatchedVideosByYourFriendsTest {
    @Test
    public void test() {
        List<List<String>> watchedVideos = new ArrayList<>();
        List<String> watchedVideos1 = new ArrayList<String>() {{
            add("A");
            add("B");
        }};
        List<String> watchedVideos2 = new ArrayList<String>() {{
            add("B");
        }};
        List<String> watchedVideos3 = new ArrayList<String>() {{
            add("B");
            add("C");
        }};
        List<String> watchedVideos4 = new ArrayList<String>() {{
            add("D");
        }};
        watchedVideos.add(watchedVideos1);
        watchedVideos.add(watchedVideos2);
        watchedVideos.add(watchedVideos3);
        watchedVideos.add(watchedVideos4);

        int[][] friends = new int[][]{{1, 2}, {0, 3}, {0, 3}, {1, 2}};
        TestCase.assertEquals(Arrays.asList("C", "B"), watchedVideosByFriends(watchedVideos, friends, 0, 1));
        TestCase.assertEquals(Collections.singletonList("D"), watchedVideosByFriends(watchedVideos, friends, 0, 2));
    }

    class VideoAndFre implements Comparable<VideoAndFre> {
        String videoName;
        Integer fre;

        public VideoAndFre(String videoName, Integer fre) {
            this.videoName = videoName;
            this.fre = fre;
        }

        public String getVideoName() {
            return videoName;
        }

        public Integer getFre() {
            return fre;
        }

        public void setFre(Integer fre) {
            this.fre = fre;
        }

        @Override
        public int compareTo(VideoAndFre o) {
            if (!this.fre.equals(o.fre)) {
                return this.fre - o.fre;
            } else {
                return this.videoName.compareTo(o.videoName);
            }
        }
    }

    private Set<Integer> currentAllFriends = new HashSet<>();

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        if (null == watchedVideos || watchedVideos.isEmpty() || null == friends || id < 0 || level < 1) {
            return Collections.emptyList();
        }
        Set<Integer> finalFriends = new HashSet<>();
        for (Integer friendId : friends[id]) {
            finalFriends.add(friendId);
        }
        currentAllFriends.add(id);
        findFinalFriends(friends, level - 1, finalFriends);
        finalFriends.removeAll(currentAllFriends);
        Map<String, VideoAndFre> videoAndFreMap = new HashMap<>();
        for (Integer finalFriendId : finalFriends) {
            for (String video : watchedVideos.get(finalFriendId)) {
                videoAndFreMap.putIfAbsent(video, new VideoAndFre(video, -1));
                VideoAndFre videoAndFre = videoAndFreMap.get(video);
                videoAndFre.setFre(videoAndFre.getFre() + 1);
            }
        }
        List<VideoAndFre> videoAndFreList = new ArrayList<>(videoAndFreMap.values());
        Collections.sort(videoAndFreList);

        List<String> watchedVideosByFriends = new ArrayList<>();
        for (VideoAndFre videoAndFre : videoAndFreList) {
            watchedVideosByFriends.add(videoAndFre.getVideoName());
        }
        return watchedVideosByFriends;
    }

    private void findFinalFriends(int[][] friends, int level, Set<Integer> finalFriends) {
        if (level == 0) {
            return;
        }
        level--;
        Set<Integer> tmpFinalFriends = new HashSet<>();
        for (Integer currentFriendId : finalFriends) {
            for (Integer nextFriendId : friends[currentFriendId]) {
                tmpFinalFriends.add(nextFriendId);
            }
        }
        currentAllFriends.addAll(finalFriends);
        tmpFinalFriends.removeAll(currentAllFriends);
        finalFriends.addAll(tmpFinalFriends);
        findFinalFriends(friends, level, finalFriends);
    }
}
