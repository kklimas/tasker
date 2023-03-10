package com.group.taskservice.model;
import com.group.taskservice.enums.TaskPriority;
import com.group.taskservice.enums.TaskStatus;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    private Employee employee;
    private String shortDescription;
    private String description;
    private Long parentId;

    @ElementCollection
    private List<Long> childrenId;

    @CreationTimestamp
    private Timestamp createdAt;
    private Timestamp deadLine;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    private TaskPriority taskPriority;
}
