package com.bupt.bsdn.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@TableName("archive_books")
public class ArchiveBook {
    @TableField("ISBN")
    @Schema(description = "ISBN")
    private String ISBN;

    @TableField("book_Title")
    @Schema(description = "标题")
    private String bookTitle;

    @TableField("book_author")
    @Schema(description = "作者")
    private String bookAuthor;

    @TableField("year_of_publication")
    @Schema(description = "出版年份")
    private Integer yearOfPublication;

    @TableField("publisher")
    @Schema(description = "出版社")
    private String publisher;

    @TableField("Image_URL_S")
    @Schema(description = "Image_URL_S")
    private String Image_URL_S;

    @TableField("Image_URL_M")
    @Schema(description = "Image_URL_M")
    private String Image_URL_M;

    @TableField("Image_URL_L")
    @Schema(description = "Image_URL_L")
    private String Image_URL_L;
}
