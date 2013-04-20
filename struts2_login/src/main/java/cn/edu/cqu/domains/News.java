package cn.edu.cqu.domains;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 新闻
 * 
 * @author hxd
 * 
 */
@Entity
@Table(name = "news")
public class News {

	@Id
	@GeneratedValue
	private Long id;
	/**
	 * title
	 */
	@Column(nullable = false, length = 100)
	private String title;
	/**
	 * author
	 */
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH }, optional = true)
	@JoinColumn(name="author_id")
	private User author;
	/**
	 * content
	 */
	@Column(nullable = false, length = 5000)
	private String content;
	/**
	 * date 
	 */
	@Column(nullable = false)
	private Date modifyDate;
	/**
	 * is news with picture
	 */
	@Column(nullable = false)
	private Boolean isPicture = false;
	/**
	 * type(notice=0,news=1)
	 */
	@Column(nullable = false)
	private Boolean isNews = false;
	/**
	 * path of picture
	 */
	@Column(nullable = true, length = 100)
	private String picturePath;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Boolean getIsNews() {
		return isNews;
	}

	public void setIsNews(Boolean isNews) {
		this.isNews = isNews;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Boolean getIsPicture() {
		return isPicture;
	}

	public void setIsPicture(Boolean isPicture) {
		this.isPicture = isPicture;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
}
