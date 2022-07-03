package com.devsuperior.dslearnbds.services;

import com.devsuperior.dslearnbds.dto.NotificationDTO;
import com.devsuperior.dslearnbds.entities.Notification;
import com.devsuperior.dslearnbds.entities.User;
import com.devsuperior.dslearnbds.repositories.NotificationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    final NotificationRepository repository;
    final AuthService authService;

    public NotificationService(NotificationRepository repository, AuthService authService) {
        this.repository = repository;
        this.authService = authService;
    }

    public Page<NotificationDTO> notificationsForCurrentUser(boolean unreadOnly, Pageable pageable) {
        User user = authService.authenticated();
        Page<Notification> page = repository.find(user, unreadOnly, pageable);
        return page.map(NotificationDTO::new);
    }
}
