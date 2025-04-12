package org.icet.upnest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class User {
    private Integer id;
    private String username;
    private String password;
}
