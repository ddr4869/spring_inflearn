package tom.study.TomTest;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
public class Post {
    @Id @GeneratedValue
    private Long id;

    private String title;

    @ManyToOne
    private User user;
}