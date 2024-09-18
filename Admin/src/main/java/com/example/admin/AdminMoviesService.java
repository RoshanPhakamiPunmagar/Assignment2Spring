package com.example.admin;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminMoviesService {
        private final AdminMoviesClient adminClient;

        public AdminMoviesService(AdminMoviesClient adminClient){
            this.adminClient = adminClient;

        }

        public void blockMovie(Long movieId) {
            adminClient.blockMovie(movieId);
        }


        public void unblockMovie(Long movieId) {
            adminClient.unblockMovie(movieId);
        }

        public boolean isMovieBlocked(Long movieId) {
            return adminClient.checkMovieStatus(movieId);
        }

        public List<Movies> getBlockedMovies() {
            return adminClient.listBlockedMovies();
        }

        public List<Movies> getUnblockedMovies() {
            return adminClient.listUnblockedMovies();
        }

        public List<Movies> getAllMovies() {
            return  adminClient.listMovies();
        }
}
