package com.template.auth.facade;

import com.template.auth.entity.*;
import com.template.auth.exceptions.UserDoesntExistException;
import com.template.auth.exceptions.UserLockedException;
import com.template.auth.exceptions.UserNotEnabledException;
import com.template.auth.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PatchMapping(path = "/shipping-details")
    public ResponseEntity<AuthResponse> addShippingDetails(HttpServletRequest request, @RequestBody ShippingDetailsDTO shippingDetailsDTO) {
        try {
            userService.addShippingDetails(request, shippingDetailsDTO);
            return ResponseEntity.ok(new AuthResponse(Code.SUCCESS));
        } catch (UserDoesntExistException e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(new AuthResponse(Code.A1));
        } catch (UserNotEnabledException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new AuthResponse(Code.A1));
        } catch (UserLockedException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new AuthResponse(Code.A7));
        }
    }

    @GetMapping("/profile")
    public ResponseEntity<UserDTO> getUserProfile(HttpServletRequest request) {
        try {
            UserDTO userDTO = userService.getUserProfile(request);
            return ResponseEntity.ok(userDTO);
        } catch (UserDoesntExistException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/favourites")
    public ResponseEntity<String> toggleFavourite(HttpServletRequest request, @RequestParam String productUid) {
        String message = userService.toggleFavourite(request, productUid);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/favourites")
    public ResponseEntity<List<SimpleProductDTO>> getFavouriteProducts(HttpServletRequest request) {
        List<SimpleProductDTO> favourites = userService.getFavouriteProducts(request);
        return ResponseEntity.ok(favourites);
    }
}
