package com.game.gameon.game.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "game_type")
@Getter
@NoArgsConstructor
public class GameTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seq;

    @Column(nullable = false, length = 200)
    private String type;
}
