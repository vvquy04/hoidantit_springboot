<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login</title>
    <!-- Bootstrap CSS -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <style>
      body {
        background: linear-gradient(to right, #4facfe, #00f2fe);
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
      }
      .card {
        border-radius: 15px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
      }
      .form-control {
        border-radius: 10px;
      }
      .btn-primary {
        border-radius: 10px;
      }
      .forgot-link {
        text-decoration: none;
        font-size: 14px;
      }
      .forgot-link:hover {
        text-decoration: underline;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-md-5">
          <div class="card p-4">
            <h3 class="text-center mb-4">Login</h3>
            <form method="post" action="/login">
              <c:if test="${param.error != null}">
                <div class="my-2" style="color: red">
                  Invalid email or password.
                </div>
              </c:if>
              <div class="mb-3">
                <input
                  type="email"
                  class="form-control"
                  placeholder="Email address"
                  name="username"
                />
              </div>
              <div class="mb-3">
                <input
                  type="password"
                  class="form-control"
                  placeholder="Password"
                  name="password"
                />
              </div>
              <div>
                <input
                  type="hidden"
                  name="${_csrf.parameterName}"
                  value="${_csrf.token}"
                />
              </div>
              <div
                class="d-flex justify-content-between align-items-center mb-3"
              >
                <div class="form-check">
                  <input
                    class="form-check-input"
                    type="checkbox"
                    id="remember"
                  />
                  <label class="form-check-label" for="remember"
                    >Remember Password</label
                  >
                </div>
                <a href="#" class="forgot-link">Forgot Password?</a>
              </div>
              <div class="d-grid mb-3">
                <button type="submit" class="btn btn-primary">Login</button>
              </div>
              <div class="text-center">
                <a href="/register">Need an account? Sign up!</a>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
