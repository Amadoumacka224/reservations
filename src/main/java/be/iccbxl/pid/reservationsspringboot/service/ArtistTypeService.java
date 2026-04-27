package be.iccbxl.pid.reservationsspringboot.service;

import be.iccbxl.pid.reservationsspringboot.model.Artist;
import be.iccbxl.pid.reservationsspringboot.model.ArtistType;
import be.iccbxl.pid.reservationsspringboot.model.Type;
import be.iccbxl.pid.reservationsspringboot.repository.ArtistTypeRepository;
import be.iccbxl.pid.reservationsspringboot.repository.TypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistTypeService {

    private final ArtistTypeRepository artistTypeRepository;
    private final TypeRepository typeRepository;

    public ArtistTypeService(ArtistTypeRepository artistTypeRepository,
                             TypeRepository typeRepository) {
        this.artistTypeRepository = artistTypeRepository;
        this.typeRepository = typeRepository;
    }

    @Transactional(readOnly = true)
    public List<Type> getAllTypes() {
        List<Type> types = new ArrayList<>();
        typeRepository.findAll().forEach(types::add);
        return types;
    }

    @Transactional
    public ArtistType getOrCreate(Artist artist, Long typeId) {
        Type type = typeRepository.findById(typeId)
                .orElseThrow(() -> new IllegalArgumentException("Type d'artiste introuvable : " + typeId));

        return artistTypeRepository.findByArtistAndType(artist, type)
                .orElseGet(() -> {
                    ArtistType at = new ArtistType();
                    at.setArtist(artist);
                    at.setType(type);
                    return artistTypeRepository.save(at);
                });
    }
}
