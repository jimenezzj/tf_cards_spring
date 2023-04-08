package com.tfcards.tf_cards_spring.commands;

import com.tfcards.tf_cards_spring.domain.EFigureSize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.*;


@NoArgsConstructor
@Getter
@Setter
public class FigureCommand {

    private Long id;

    //    @NotBlank
    @Min(value = 2017, message = "Release year must be bigger or equal to 2017")
    private int releaseYear;
    @NotBlank
    private String name;
    @NotNull
    private EFigureSize size;
    private ItemNotesCommand notes;

    //    @NotNull
    private MultipartFile image;
    private Byte[] imageByteArr;
    private Set<FigureAccessoryCommand> accessories = new HashSet<>();
    private CollectionGroupCommand collectGrp;
//    private Set<FiguresCollectorCommand> figureCollectors = new HashSet<>();

}
