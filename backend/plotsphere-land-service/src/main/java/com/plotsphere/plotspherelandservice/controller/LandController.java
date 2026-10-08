package com.plotsphere.plotspherelandservice.controller;

import com.plotsphere.plotspherelandservice.entity.Land;
import com.plotsphere.plotspherelandservice.service.LandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lands")
public class LandController {

    private final LandService landService;

    public LandController(LandService landService) {
        this.landService = landService;
    }

    @PostMapping
    public ResponseEntity<Land> addLand(@RequestBody Land land) {
        return ResponseEntity.ok(landService.addLand(land));
    }

    @GetMapping
    public ResponseEntity<List<Land>> getAllLands() {
        return ResponseEntity.ok(landService.getAllLands());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Land> getLandById(@PathVariable Long id) {
        return ResponseEntity.ok(landService.getLandById(id));
    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<Land>> getLandsByOwner(
            @PathVariable Long ownerId) {

        return ResponseEntity.ok(
                landService.getLandsByOwner(ownerId)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Land> updateLand(
            @PathVariable Long id,
            @RequestBody Land land) {

        return ResponseEntity.ok(
                landService.updateLand(id, land)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLand(@PathVariable Long id) {

        landService.deleteLand(id);

        return ResponseEntity.ok("Land deleted successfully");
    }
}