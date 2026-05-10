package com.example.folio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "blocks")
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String content;

    @ManyToOne
    @JoinColumn(name = "page_id")
    private Page page;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Page getPage() { return page; }
    public void setPage(Page page) { this.page = page; }
}
