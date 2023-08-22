package com.example.organizer.controllers;

import com.example.organizer.dtos.ItemDto;
import com.example.organizer.entities.Item;
import com.example.organizer.services.OrganizerService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("item")
public class ItemController {

    private final OrganizerService organizerService;
    private  final ModelMapper modelMapper;

    public ItemController(OrganizerService organizerService, ModelMapper modelMapper) {
        this.organizerService = organizerService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<String> createItem(@RequestBody ItemDto itemDto) {
        try {
            Item item = convertToItemEntity(itemDto);
            organizerService.createItem(item);
        }
        catch(Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
        return ResponseEntity.ok("Item created");
    }

    @PutMapping
    public  ResponseEntity<String> updateItem(@RequestBody ItemDto itemDto) {
        try {
            Item item = convertToItemEntity(itemDto);
            organizerService.updateItem(item);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

        return ResponseEntity.ok("Item updated");
    }

    @DeleteMapping("/{itemID}")
    public ResponseEntity<String> deleteItemById(@PathVariable String itemID) {
        organizerService.deletedItemById(itemID);
        return ResponseEntity.ok("Item deleted");
    }

    private ItemDto convertToItemDto(Item item) {
        return modelMapper.map(item, ItemDto.class);
    }
    private Item convertToItemEntity(ItemDto itemDto) throws ParseException {
        return modelMapper.map(itemDto, Item.class);
    }
}
