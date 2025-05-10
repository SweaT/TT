package com.example.TT.persistent.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "subscribers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SubscriberEntity {

    @EmbeddedId
    private SubscriberId id;

    // Связи с другими таблицами
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "login",
            referencedColumnName = "login",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "subscribers_login_fk"))
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event",
            referencedColumnName = "id",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "subscribers_event_fk"))
    private EventEntity eventEntity;
}
