package ua.senadnepr.teplopol;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force=true)
@Entity
public class Material {

    @Id
    private final String id;
    private final String name;
    private final Type type;
    private final Integer price;

    public static enum Type {
        POLIIZOL, THERMOSTAT, CABLE
    }
}
