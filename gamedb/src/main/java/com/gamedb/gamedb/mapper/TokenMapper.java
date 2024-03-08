public class TokenMapper {

    public TokenEntity toEntity(Token dto) {
        TokenEntity entity = new TokenEntity();
        entity.setToken(dto.getToken());
        return entity;
    }
    public Token toDto(TokenEntity entity) {
        Token dto = new Token();
        dto.setToken(entity.getToken());
        return dto;
    }
}
