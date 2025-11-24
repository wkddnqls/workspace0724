<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String currentPage = request.getParameter("page");
    if (currentPage == null || currentPage.isEmpty()) {
        currentPage = "dashboard";
    }
    
    String pageTitle = "";
    switch(currentPage) {
        case "dashboard": pageTitle = "대시보드"; break;
        case "schedule": pageTitle = "콘텐츠 일정"; break;
        case "revenue": pageTitle = "수익 관리"; break;
        case "sponsorships": pageTitle = "협찬 계약"; break;
        default: pageTitle = "대시보드";
    }
%>
    
    
    
<!DOCTYPE html>

<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>크리에이터 ERP 시스템</title>
    
    <!-- Tailwind CSS -->
    <script src="https://cdn.tailwindcss.com"></script>
    
    <!-- Chart.js -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.0/dist/chart.umd.min.js"></script>
    
    <!-- Lucide Icons -->
    <script src="https://unpkg.com/lucide@latest"></script>
    
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Helvetica Neue', Arial, sans-serif;
            background-color: #f8fafc;
        }

        .sidebar {
            width: 250px;
            background: white;
            border-right: 1px solid #e2e8f0;
            height: 100vh;
            position: fixed;
            left: 0;
            top: 0;
            overflow-y: auto;
            z-index: 20;
        }

        .sidebar-header {
            padding: 1.5rem;
            border-bottom: 1px solid #e2e8f0;
        }

        .sidebar-header h1 {
            font-size: 1.25rem;
            font-weight: 700;
            color: #7c3aed;
        }

        .sidebar-menu {
            padding: 1rem;
        }

        .menu-label {
            font-size: 0.75rem;
            font-weight: 600;
            color: #64748b;
            padding: 0.5rem 0.75rem;
            text-transform: uppercase;
            letter-spacing: 0.05em;
        }

        .menu-item {
            display: flex;
            align-items: center;
            gap: 0.75rem;
            padding: 0.75rem;
            margin-bottom: 0.25rem;
            border-radius: 0.375rem;
            cursor: pointer;
            color: #334155;
            transition: all 0.2s;
            text-decoration: none;
        }

        .menu-item:hover {
            background-color: #f1f5f9;
        }

        .menu-item.active {
            background-color: #ede9fe;
            color: #7c3aed;
        }

        .main-content {
            margin-left: 250px;
            min-height: 100vh;
        }

        .top-bar {
            background: white;
            border-bottom: 1px solid #e2e8f0;
            padding: 1rem 1.5rem;
            display: flex;
            align-items: center;
            gap: 1rem;
            position: sticky;
            top: 0;
            z-index: 10;
        }

        .menu-toggle {
            display: none;
            cursor: pointer;
            padding: 0.5rem;
            border-radius: 0.375rem;
        }

        .menu-toggle:hover {
            background-color: #f1f5f9;
        }

        @media (max-width: 768px) {
            .sidebar {
                transform: translateX(-100%);
                transition: transform 0.3s ease;
            }

            .sidebar.show {
                transform: translateX(0);
            }

            .main-content {
                margin-left: 0;
            }

            .menu-toggle {
                display: block;
            }
        }
    </style>
</head>
<body>
    <!-- Sidebar -->
    <aside class="sidebar" id="sidebar">
        <div class="sidebar-header">
            <h1>크리에이터 ERP</h1>
        </div>
        <nav class="sidebar-menu">
            <div class="menu-label">메뉴</div>
            <a href="?page=dashboard" class="menu-item <%= currentPage.equals("dashboard") ? "active" : "" %>">
                <i data-lucide="layout-dashboard" width="18" height="18"></i>
                <span>대시보드</span>
            </a>
            <a href="?page=schedule" class="menu-item <%= currentPage.equals("schedule") ? "active" : "" %>">
                <i data-lucide="calendar" width="18" height="18"></i>
                <span>콘텐츠 일정</span>
            </a>
            <a href="?page=revenue" class="menu-item <%= currentPage.equals("revenue") ? "active" : "" %>">
                <i data-lucide="dollar-sign" width="18" height="18"></i>
                <span>수익 관리</span>
            </a>
            <a href="?page=sponsorships" class="menu-item <%= currentPage.equals("sponsorships") ? "active" : "" %>">
                <i data-lucide="handshake" width="18" height="18"></i>
                <span>협찬 계약</span>
            </a>
        </nav>
    </aside>

    <!-- Main Content -->
    <main class="main-content">
        <!-- Top Bar -->
        <div class="top-bar">
            <div class="menu-toggle" id="menuToggle">
                <i data-lucide="menu" width="24" height="24"></i>
            </div>
            <h2 class="text-xl font-semibold"><%= pageTitle %></h2>
        </div>

        <!-- Content Area -->
        <div class="p-6">
            <%
                String pagePath = "/pages/" + currentPage + ".jsp";
                try {
            %>
                <jsp:include page="<%= pagePath %>" />
            <%
                } catch (Exception e) {
            %>
                <jsp:include page="/pages/dashboard.jsp" />
            <%
                }
            %>
        </div>
    </main>

    <script>
        // Menu Toggle for Mobile
        const menuToggle = document.getElementById('menuToggle');
        const sidebar = document.getElementById('sidebar');

        if (menuToggle && sidebar) {
            menuToggle.addEventListener('click', () => {
                sidebar.classList.toggle('show');
            });
        }

        // Initialize Lucide Icons
        lucide.createIcons();
    </script>
</body>
</html>
