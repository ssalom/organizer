package com.example.organizer.controllers;

import com.example.organizer.dtos.ItemDto;
import com.example.organizer.dtos.UserDto;
import com.example.organizer.entities.Item;
import com.example.organizer.entities.User;
import com.example.organizer.services.OrganizerService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("user")
public class UserController {

    private final OrganizerService organizerService;

    private final ModelMapper modelMapper;

    public UserController(OrganizerService organizerService, ModelMapper modelMapper) {
        this.organizerService = organizerService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public @ResponseBody ResponseEntity<String> createUser(@RequestBody UserDto userDto) {
       try {
            User user = convertToUserEntity(userDto);
            organizerService.createUser(user);
        }
        catch (Exception e) {
            return  ResponseEntity.internalServerError().body(e.getMessage());
        }

        return ResponseEntity.ok("User created.");
    }

    @PutMapping
    public @ResponseBody ResponseEntity<String> updateUserById(@RequestBody UserDto userDto) {
        try {
            User user = convertToUserEntity(userDto);
            organizerService.updateUser(user);
        } catch (Exception e) {
            return  ResponseEntity.internalServerError().body(e.getMessage());
        }

        return ResponseEntity.ok("User updated.");
    }

    @GetMapping("/{userID}")
    public ResponseEntity<UserDto> getUserByUserId(@PathVariable String userID) {
        try {
            User user = organizerService.getUserById(userID).get();
            return ResponseEntity.ok(convertToUserDto(user));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{userID}/items")
    public ResponseEntity<List<ItemDto>> getItemsByUserId(@PathVariable String userID) {
            List<ItemDto> itemDtos = organizerService.getItemsByUser(userID)
                    .stream()
                    .map(this::convertToItemDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(itemDtos);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDtos = organizerService.getUsers()
                .stream()
                .map(this::convertToUserDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(userDtos);
    }

    @DeleteMapping("/{userID}")
    public ResponseEntity<String> deletedUserById(@PathVariable String userID) {
        organizerService.deletedUserById(userID);
        return ResponseEntity.ok("User deleted");
    }


    private UserDto convertToUserDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    private User convertToUserEntity(UserDto userDto) throws ParseException {
        return modelMapper.map(userDto, User.class);
    }

    private ItemDto convertToItemDto(Item item) {
        return modelMapper.map(item, ItemDto.class);
    }
}
