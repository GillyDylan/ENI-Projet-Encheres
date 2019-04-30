<form action="ServletConnexion" method="post">
  <div class="form-group">
    <label for="login">Identifiant</label>
    <input type="login" class="form-control" name="login">
  </div>
  <div class="form-group">
    <label for="mdp">Mot de passe:</label>
    <input type="password" class="form-control" name="mdp">
  </div>
  <div class="form-group form-check">
    <label class="form-check-label">
      <input class="form-check-input" type="checkbox"> Se souvenir de moi
    </label>
  </div>
  <button type="submit" class="btn btn-primary">Se connecter</button>
</form>