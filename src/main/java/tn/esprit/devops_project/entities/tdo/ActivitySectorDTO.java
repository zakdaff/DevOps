package tn.esprit.devops_project.entities.tdo;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.devops_project.entities.Supplier;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActivitySectorDTO {
     Long idSecteurActivite;
     String codeSecteurActivite;
     String libelleSecteurActivite;
     Supplier supplierss;

}

