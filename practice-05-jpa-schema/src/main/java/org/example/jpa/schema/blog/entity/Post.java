package org.example.jpa.schema.blog.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "blog_post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false, length = 128)
    private String title;

    @Column(name = "subtitle", nullable = true, length = 64)
    private String subtitle;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @ToString.Exclude
    @ManyToOne(targetEntity = Author.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @ToString.Exclude
    @OneToMany(targetEntity = Tag.class, mappedBy = "post")
    private Set<Tag> tags;
}
